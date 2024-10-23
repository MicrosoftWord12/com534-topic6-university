// MenuItem
// A data class which represents a single menu item.
// It has a title plus a handler. The onMenuItemSelected() of the handler will run when the menu item is selected.
data class MenuItem (val title: String, val handler: MenuItemHandler)