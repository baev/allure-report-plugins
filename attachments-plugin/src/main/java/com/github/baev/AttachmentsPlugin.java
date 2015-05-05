package com.github.baev;

import ru.yandex.qatools.allure.data.AllureAttachment;
import ru.yandex.qatools.allure.data.AllureStep;
import ru.yandex.qatools.allure.data.AllureTestCase;
import ru.yandex.qatools.allure.data.plugins.DefaultTabPlugin;
import ru.yandex.qatools.allure.data.plugins.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 20.04.15
 */
@Plugin.Name("attachmentsList")
public class AttachmentsPlugin extends DefaultTabPlugin {

    @Plugin.Data
    protected List<AllureAttachment> attachments = new ArrayList<>();

    public void process(AllureTestCase data) {
        for (AllureStep step : data.getSteps()) {
            getAttachmentsFrom(step);
        }

        for (AllureAttachment attachment : data.getAttachments()) {
            attachments.add(attachment);
        }
    }

    public void getAttachmentsFrom(AllureStep step) {
        for (AllureStep subStep : step.getSteps()) {
            getAttachmentsFrom(subStep);
        }

        for (AllureAttachment attachment : step.getAttachments()) {
            attachments.add(attachment);
        }
    }
}
