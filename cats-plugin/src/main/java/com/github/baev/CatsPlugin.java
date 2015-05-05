package com.github.baev;

import ru.yandex.qatools.allure.data.AllureTestCase;
import ru.yandex.qatools.allure.data.plugins.DefaultTabPlugin;
import ru.yandex.qatools.allure.data.plugins.Plugin;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 17.04.15
 */
@Plugin.Name("cats")
public class CatsPlugin extends DefaultTabPlugin {

    public void process(AllureTestCase data) {
        //do nothing
    }
}
