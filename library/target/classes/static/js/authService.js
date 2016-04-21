/**
 * Created by Grzegorz on 2016-04-20.
 */
angular.module('bookStore')
    .service('Auth', function ($location, $http, Session, $q, UserRepository, translateFilter, $timeout) {

        this.loadUserData = function (success, error) {

            var deferred = $q.defer();

            UserRepository.user().success(function (data) {

                if (angular.isObject(data)) {

                    Session.create({
                        userId: data.id,
                        username: data.firstName + ' ' + data.lastName,
                        roles: data.authorities,
                        projects: data.assignedProjects,
                        company: data.company,
                        managedProjects: data.managedProjects
                    });

                    if (angular.isFunction(success)) {
                        success(data);
                    }

                }
                deferred.resolve(data);
            }).error(function () {

                if (angular.isFunction(error)) {
                    error();
                }
                deferred.resolve();
            });


            return deferred.promise;
        };
        var that = this;

        this.login = function (credentials, success, error) {
            UserRepository.login(credentials.username, credentials.password).success(function (data, status) {
                $timeout(function () {
                    that.loadUserData(function (data) {
                        success(data);
                        if (that.hasAnyRole('COMPANY_MANAGER')) {
                            $location.path('/admin/projects');
                        } else {
                            $location.path('/');
                        }

                    });
                }, 100);
            }).error(function (data, status) {
                var msg;
                if (status === 401 || status === 403) {
                    msg = translateFilter('INVALID_CREDENTIALS');
                } else {
                    msg = translateFilter('SERVER_ERROR_TRY_AGAIN');
                }
                error({
                    msg: msg
                });
            });
        };
        this.logout = function () {
            Session.destroy();
            $http.get('/logout');
            $location.path('/login');
        };
        this.isLoggedIn = function () {
            return Session.exists();
        };
        this.user = function (key) {
            return Session.get(key);
        };
        this.hasAnyRole = function () {
            var roles = Session.get('roles');
            if (roles) {
                for (var i = 0; i < arguments.length; i++) {
                    if (roles.indexOf(arguments[i]) !== -1) {
                        return true;
                    }
                }
                return false;
            }
            else {
                return true;
            }
        };
        this.isProjectManager = function () {
            var projects = this.user('managedProjects');
            if (angular.isDefined(projects)) {
                return !!projects.length;
            }
            return false;
        };
    });