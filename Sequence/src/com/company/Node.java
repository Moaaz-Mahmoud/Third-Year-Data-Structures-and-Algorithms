package com.company;

public class Node
{
    // Invariant of the Node class:
// 1. The node’s integer data is in the instance variable data.
// 2. For the final node of a list, the link part is null.
// Otherwise, the link part is a reference to the next node of the list.
    private int data;
    private Node link;
    public Node(){}
    public Node(int initialData, Node initialLink)
    {
        data = initialData;
        link = initialLink;
    }
    public void addNodeAfter(int element)
    {
        link = new Node(element, link);
    }
    public int getData( )
    {
        return data;
    }
    public Node getLink( )
    {
        return link;
    }
    public static Node listCopy(Node source)
    {
        Node copyHead;
        Node copyTail;
// Handle the special case of an empty list.
        if (source == null)
            return null;
// Make the first node for the newly created list.
        copyHead = new Node(source.data, null);
        copyTail = copyHead;
// Make the rest of the nodes for the newly created list.
        while (source.link != null)
        {
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
// Return the head reference for the new list.
        return copyHead;
    }
    public static Node[ ] listCopyWithTail(Node source)
    {
// Notice that the return value is an array of two Node components.
// The [0] component is the head reference for the new list and
// the [1] component is the tail reference for the new list.
// Also notice that the answer array is automatically initialized to contain
// two null values. Arrays with components that are references are always
// initialized this way.
        Node copyHead;
        Node copyTail;
        Node[ ] answer = new Node[2];
// Handle the special case of an empty list.
        if (source == null)
            return answer; // The answer has two null references.
// Make the first node for the newly created list.
        copyHead = new Node(source.data, null);
        copyTail = copyHead;
// Make the rest of the nodes for the newly created list.
        while (source.link != null)
        {
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
// Return the head and tail references for the new list.
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }
    public static int listLength(Node head)
    {
        Node cursor;
        int answer;
        answer = 0;
        for (cursor = head; cursor != null; cursor = cursor.link)
            answer++;
        return answer;
    }
    public static Node[ ] listPart(Node start, Node end)
    {
// Notice that the return value is an array of two Node components.
// The [0] component is the head reference for the new list,
// and the [1] component is the tail reference for the new list.
        Node copyHead;
        Node copyTail;
        Node[ ] answer = new Node[2];
// Check for illegal null at start or end.
        if (start == null)
            throw new IllegalArgumentException("start is null");
        if (end == null)
            throw new IllegalArgumentException("end is null");
// Make the first node for the newly created list.
        copyHead = new Node(start.data, null);
        copyTail = copyHead;
// Make the rest of the nodes for the newly created list.
        while (start != end)
        {
            start = start.link;
            if (start == null)
                throw new IllegalArgumentException
                        ("end node was not found on the list");
            copyTail.addNodeAfter(start.data);
            copyTail = copyTail.link;
        }
// Return the head and tail reference for the new list.
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }
    public static Node listPosition(Node head, int position)
    {
        Node cursor;
        int i;
        if (position <= 0)
            throw new IllegalArgumentException("position is not positive.");
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;
        return cursor;
    }
    public static Node listSearch(Node head, int target)
    {
        Node cursor;
        for (cursor = head; cursor != null; cursor = cursor.link)
            if (target == cursor.data)
                return cursor;
        return null;
    }
    public void removeNodeAfter( )
    {
        link = link.link;
    }
    public void setData(int newData)
    {
        data = newData;
    }
    public void setLink(Node newLink)
    {
        link = newLink;
    }
}