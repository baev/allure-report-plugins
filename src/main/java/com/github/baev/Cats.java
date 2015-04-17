package com.github.baev;

import ru.yandex.qatools.allure.data.AllureTestCase;
import ru.yandex.qatools.allure.data.plugins.Plugin;
import ru.yandex.qatools.allure.data.plugins.PluginData;
import ru.yandex.qatools.allure.data.plugins.ProcessPlugin;

import java.util.Collections;
import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 17.04.15
 */
@Plugin.Name("cats")
public class Cats implements ProcessPlugin<AllureTestCase> {

    public void process(AllureTestCase data) {
        //do nothing
    }

    public List<PluginData> getPluginData() {
        return Collections.singletonList(
                new PluginData("cats.json", new MyPluginContent("MY_PLUGIN_CONTENT"))
        );
    }

    public Class<AllureTestCase> getType() {
        return AllureTestCase.class;
    }

    public static class MyPluginContent {

        private String field;

        public MyPluginContent(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }
    }
}
