using DemoApp;

if (args[0] == "items")
{
    Item[] items = Shop.GetItems();
    items.Prepare("<{0}/>")
        .PrintEach();
}