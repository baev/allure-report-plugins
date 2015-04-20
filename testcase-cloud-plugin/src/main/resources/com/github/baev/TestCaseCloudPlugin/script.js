/*global angular*/
(function() {
    "use strict";
    var module = angular.module('allure.testCaseCloud', ['angular-jqcloud']);
    module.config(['$stateProvider', 'allureTabsProvider', 'testcaseProvider', function($stateProvider, allureTabsProvider, testcaseProvider) {
        allureTabsProvider.addTab('testCaseCloud', {title: 'testCaseCloud.TITLE', icon: 'fa fa-cloud'});
        testcaseProvider.attachStates('testCaseCloud');
        allureTabsProvider.addTranslation('testCaseCloud');
    }]);
    module.controller('TestCaseCloudCtrl', ['$scope', '$state', 'data', function($scope, $state, data) {
        "use strict";
        $scope.words = data.map(function(item) {
            return {
                text: item.key,
                weight: Math.random() * 20,
                html: {
                    "class": 'text-status-' + item.value.toLowerCase()
                }
            }
        });
    }]);
})();
