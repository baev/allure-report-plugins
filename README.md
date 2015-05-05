## Allure sample report plugins

Simple clone this project and run `mvn clean verify` to run integration test.
After it you can find results in `target/it` folder.

### Cats

It is simple plugin without any data processing - just new tab with few (only one for now)
nice cats.

![2015-04-20 18 19 31](https://cloud.githubusercontent.com/assets/2149631/7233596/9973a46e-e78a-11e4-85bc-7e090a216505.png)

### Test cases cloud

This example shows how you can load and use other dependencies. Also in this example all
user styles and scripts are minimized. So in feature I plan to make some thing (I guess maven plugin)
which helps you to manage your java script dependencies and minimizing.

![2015-04-20 18 27 13](https://cloud.githubusercontent.com/assets/2149631/7233650/ea38354a-e78a-11e4-8d01-155ad47d475a.png)

### Attachments

This example shows how to collect data to your plugins. I simply collect all attachments to
one object and then serialize it to `json`. 

![2015-04-20 18 24 13](https://cloud.githubusercontent.com/assets/2149631/7233617/c0ab17d8-e78a-11e4-800a-1d3633df65c9.png)
