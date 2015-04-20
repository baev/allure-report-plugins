package com.github.baev;

import ru.yandex.qatools.allure.data.AllureTestCase;
import ru.yandex.qatools.allure.data.plugins.Plugin;
import ru.yandex.qatools.allure.data.plugins.PluginData;
import ru.yandex.qatools.allure.data.plugins.TabPlugin;

import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 17.04.15
 */
@Plugin.Name("cats")
public class CatsPlugin extends TabPlugin {

    public void process(AllureTestCase data) {
        //do nothing
    }

    public List<PluginData> getPluginData() {
        return null;
    }
}
