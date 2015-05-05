package ru.lanwen.report;

import ru.yandex.qatools.allure.data.AllureTestCase;
import ru.yandex.qatools.allure.data.plugins.DefaultTabPlugin;
import ru.yandex.qatools.allure.data.plugins.Plugin;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 05.05.15
 */
@Plugin.Name("packagesList")
public class PackagesPlugin extends DefaultTabPlugin {
    @Override
    public void process(AllureTestCase data) {
    }
}
