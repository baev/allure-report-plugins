/*global angular*/
(function() {
    "use strict";
    var module = angular.module('allure.attachmentsList', []);
    module.config(['$stateProvider', 'allureTabsProvider', function($stateProvider, allureTabsProvider) {
        allureTabsProvider.addTab('attachmentsList', {title: 'attachmentsList.TITLE', icon: 'fa fa-file-text-o'});
        $stateProvider.state('attachmentsList.attachment', {
            url: '/:attachmentUid'
        });
        allureTabsProvider.addTranslation('attachmentsList');
    }]);
    module.controller('AttachmentsListCtrl', ['$scope', '$state', 'data', function($scope, $state, data) {
        "use strict";
        $scope.attachments = data;
        var baseState = 'attachmentsList';

        $scope.setAttachment = function(attachmentUid) {
            $state.go(baseState + '.attachment', {attachmentUid: attachmentUid});
        };

        $scope.isState = function(statename) {
            return $state.is(statename);
        };

        function setAttachment(uid) {
            $scope.attachment = $scope.attachments.filter(function(attachment) {
                return attachment.uid === uid;
            })[0];
        }

        $scope.$on('$stateChangeSuccess', function(event, state, params) {
            delete $scope.attachment;
            if(params.attachmentUid) {
                setAttachment(params.attachmentUid);
            }
        });
    }]);
    module.controller('AttachmentsListAttachmentPreviewCtrl', ['$scope', '$http', '$state', 'attachmentType', 'd3', function($scope, $http, $state, attachmentType, d3) {
        "use strict";
        var baseState = 'attachmentsList';

        function fileGetContents(url) {
            //get raw file content without parsing
            $http.get(url, {transformResponse: []}).then(function(response) {
                $scope.attachText = response.data;
                if($scope.type === 'csv') {
                    $scope.rows = d3.csv.parseRows(response.data);
                }
            }, $scope.onError);
        }

        $scope.onError = function() {
            $scope.notFound = true;
        };
        $scope.getSourceUrl = function(attachment) {
            return 'data/' + attachment.source;
        };
        $scope.isExpanded = function() {
            return $state.is(baseState + '.attachment.expanded');
        };
        $scope.toggleExpanded = function() {
            $state.go(baseState + '.attachment' + ($scope.isExpanded() ? '' : '.expanded'));
        };
        $scope.$watch('attachment', function(attachment) {
            $scope.notFound = false;
            $scope.type = attachmentType(attachment.type);
            $scope.language = $scope.type === 'code' ? attachment.type.split('/').pop() : undefined;
            if($scope.type === 'text' || $scope.type === 'code' || $scope.type === 'csv') {
                fileGetContents($scope.getSourceUrl(attachment));
            }
        });
    }]);
})();
