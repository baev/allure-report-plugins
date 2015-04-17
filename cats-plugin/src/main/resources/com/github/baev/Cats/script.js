/*global angular*/
(function() {
    "use strict";
    var module = angular.module('allure.cats', []);
    module.config(function($stateProvider, allureTabsProvider, testcaseProvider) {
        allureTabsProvider.addTab('cats', {title: 'cats.TITLE', icon: 'fa fa-paw', resolve: {}});
        testcaseProvider.attachStates('cats');
        allureTabsProvider.addTranslation('cats');
    });
    module.controller('CatsCtrl', function($scope, $state, data) {
        "use strict";
    });
})();
