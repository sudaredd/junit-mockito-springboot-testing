package app.unittesting;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

  List<String> mockList = mock(List.class);

  @Test
  public void test() {

    when(mockList.size()).thenReturn(50);

    assertEquals(50, mockList.size());

    assertEquals(50, mockList.size());
  }

  @Test
  public void testReturnDifferentValues() {

    when(mockList.size()).thenReturn(50).thenReturn(100).thenReturn(250);

    assertEquals(50, mockList.size());
    assertEquals(100, mockList.size());
    assertEquals(250, mockList.size());
  }

  @Test
  public void testWithParameters() {

    when(mockList.get(0)).thenReturn("first value");
    when(mockList.get(5)).thenReturn("fifth value");
    when(mockList.get(10)).thenReturn("tenth value");

    assertEquals("first value", mockList.get(0));
    assertEquals("fifth value", mockList.get(5));
    assertEquals("tenth value", mockList.get(10));
    assertEquals(null, mockList.get(100));
  }

  @Test
  public void testWithAnyParameters() {

    List mockList = mock(List.class);

    String any_value = "any value";

    when(mockList.get(anyInt())).thenReturn(any_value);

    assertEquals(any_value, mockList.get(0));
    assertEquals(any_value, mockList.get(5));
    assertEquals(any_value, mockList.get(10));
    assertEquals(any_value, mockList.get(100));
  }

  @Test
  public void testVerificationBasics() {

    String val = mockList.get(10);

    String val1 = mockList.get(11);

    // verify
    verify(mockList).get(10);
    verify(mockList, times(1)).get(10);
    verify(mockList, times(0)).get(0);
    verify(mockList, times(2)).get(anyInt());
    verify(mockList, atLeast(1)).get(anyInt());
    verify(mockList, atMost(2)).get(anyInt());
    verify(mockList, never()).get(2);
  }

  @Test
  public void testArgumentCapturing() {

    mockList.add("someString");

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    verify(mockList).add(captor.capture());

    assertEquals("someString", captor.getValue());
  }

  @Test
  public void testArgumentCapturingMultipleCalls() {

    mockList.add("String1");

    mockList.add("String2");

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    verify(mockList, times(2)).add(captor.capture());

    assertEquals(List.of("String1", "String2"), captor.getAllValues());
  }

  @Test
  public void testMocking() {
    ArrayList arrayListMock = mock(ArrayList.class);

    System.out.println(arrayListMock.get(0));
    System.out.println(arrayListMock.size());

    arrayListMock.add("test1");
    arrayListMock.add("test2");

    System.out.println(arrayListMock.get(0)); // return null
    System.out.println(arrayListMock.size()); // return 0

    when(arrayListMock.size()).thenReturn(5);
    System.out.println(arrayListMock.size()); // print 5
  }

  @Test
  public void testSpy() {

    ArrayList arrayListSpy = spy(ArrayList.class);

    try {
      System.out.println(arrayListSpy.get(0)); // throws exception
    } catch (IndexOutOfBoundsException ex) {
      System.err.println("Index out of bound exception");
    }
    System.out.println(arrayListSpy.size()); // returns 0

    arrayListSpy.add("test1");
    arrayListSpy.add("test2");

    System.out.println(arrayListSpy.get(0)); // return test1
    System.out.println(arrayListSpy.size()); // return 2

    when(arrayListSpy.size()).thenReturn(5);
    System.out.println(arrayListSpy.size()); // print 5

    arrayListSpy.add("test3");
    System.out.println(arrayListSpy.size()); // print 5

    verify(arrayListSpy).add("test3");


  }
}
