import com.datastructures.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    MyStack myStack;

    @BeforeEach
    void startWithThis(){
        myStack = new MyStack(5);
    }

    @Test
    void pushOneElementTest(){
        myStack.push(5);
        assertEquals(5, myStack.peek());
    }

    @Test
    void pushTwoElementsTest(){
        myStack.push(8);
        myStack.push(6);
        assertEquals(6, myStack.peek());
    }

    @Test
    void pushTwoElements_popOneTest(){
        myStack.push(4);
        myStack.push(11);

        assertEquals(11,myStack.removeLastElement());
        assertEquals(4,myStack.peek());
    }

    @Test
    void pushTwo_popTwo_shouldBeEmpty(){
        myStack.push(4);
        myStack.push(11);
        myStack.removeLastElement();
        myStack.removeLastElement();

        assertTrue(myStack.isEmpty());
    }

    @Test
    void pushThree_shouldBeFullTest(){
        myStack = new MyStack(3);
        myStack.push(4);
        myStack.push(11);
        myStack.push(3);
        assertTrue(myStack.isFull());
    }

    @Test
    void pushOneElement_afterStackIsFull_ThrowsStackOverflowException(){
        myStack = new MyStack(3);
        myStack.push(4);
        myStack.push(11);
        myStack.push(3);
        assertTrue(myStack.isFull());
        assertThrows(MyStack.StackOverflowException.class, ()-> myStack.push(5));
    }

    @Test
    void removelastElement_whenStackIsEmpty_throwsStackUnderflowException(){
        assertTrue(myStack.isEmpty());
        assertThrows(MyStack.StackUnderflowException.class, () -> myStack.removeLastElement());
    }

    @Test
    void peekEmptyStack_throwsStackUnderflowException(){
        assertTrue(myStack.isEmpty());
        assertThrows(MyStack.StackUnderflowException.class, () -> myStack.peek());
    }
}
