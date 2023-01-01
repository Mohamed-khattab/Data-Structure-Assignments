class Link
{
    public Link(int id, int data) // constructor
    {
        iData = id;
        // initialize data
        dData = data;
        // (‘next’ is automatically
    }public int iData;
    // data item (key)
    public int dData;
    // data item
    public Link next;
    // next link in list


    // set to null)
    public void displayLink()
    // display ourself
    {
        System.out.print("{" + iData + "," + dData + "} ");
    }
} // end class Link


class LinkList
{
    private Link first;
    // ref to first link on list
// -------------------------------------------------------------
    public LinkList()
    // constructor
    {
        first = null;
        // no items on list yet
    }
    // -------------------------------------------------------------
    public boolean isEmpty()
    // true if list is empty
    {
        return (first==null);
    }
    // -------------------------------------------------------------
// insert at start of list
    public void insertFirst(int id, int dd)
    {
        // make new link
        Link newLink = new Link(id, dd);
        newLink.next = first;
        // newLink --> old first
        first = newLink;
        // first --> newLink
    }
    // -------------------------------------------------------------
    public Link delete(int key)
    // delete link with given key
    {
        // (assumes non-empty list)
        Link current = first;
        // search for link
        Link previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null; // didn’t find it
            else
            {
                previous = current; // go to next link
                current = current.next;
            }
        }
        // found it
        if(current == first)// if first link,
            first = first.next;

        else                // otherwise,
        previous.next = current.next;
        //
        return current;
    }



    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        // start at beginning of list
        while(current != null)
        // until end of list,
        {
            current.displayLink();
            // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}

class LinkListApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList(); // make new list


    }
}
