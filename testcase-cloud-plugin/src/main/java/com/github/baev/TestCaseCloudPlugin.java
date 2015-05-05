package com.github.baev;

import ru.yandex.qatools.allure.data.AllureTestCase;
import ru.yandex.qatools.allure.data.plugins.DefaultTabPlugin;
import ru.yandex.qatools.allure.data.plugins.Plugin;
import ru.yandex.qatools.allure.data.plugins.PluginData;
import ru.yandex.qatools.allure.model.Status;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 17.04.15
 */
@Plugin.Name("testCaseCloud")
public class TestCaseCloudPlugin extends DefaultTabPlugin {

    private Map<String, Status> names = new HashMap<>();

    public void process(AllureTestCase data) {
        names.put(data.getTitle(), data.getStatus());
    }

    @Override
    public List<PluginData> getPluginData() {
        return Collections.singletonList(new PluginData("testCaseCloud.json", names.entrySet()));
    }
}
