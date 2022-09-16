//package com.abcool.unittesting.powermock;
//
//import com.abcool.unittesting.powermock.Dependency;
//import com.abcool.unittesting.powermock.SystemUnderTest;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.mock;
//import static org.powermock.api.mockito.PowerMockito.when;
//import static org.powermock.api.support.membermodification.MemberModifier.stub;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(SystemUnderTest.class)
//public class PowerMockConstructorTest {
//
//    private static final int SOME_DUMMY_SIZE = 100;
//
//    @Mock
//    Dependency dependencyMock;
//
//    @InjectMocks
//    SystemUnderTest systemUnderTest;
//
//    @Test
//    public void powerMockito_MockingAConstructor() throws Exception {
//
//        ArrayList<String> mockList = mock(ArrayList.class);
//
//        when(mockList.size()).thenReturn(SOME_DUMMY_SIZE);
//
//        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(
//                mockList);
//
//        int size = systemUnderTest.methodUsingAnArrayListConstructor();
//
//        assertEquals(SOME_DUMMY_SIZE, size);
//    }
//
//}
