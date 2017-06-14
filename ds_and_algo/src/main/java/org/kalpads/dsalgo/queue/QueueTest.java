package org.kalpads.dsalgo.queue;

/**
 * Created by kalpasenanayake on 7/6/17.
 */
public class QueueTest {

    public static void main(String [] args) {
        Queue queue = new Queue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.view();

        queue.remove();
        queue.remove();

        queue.view();

    }
}
