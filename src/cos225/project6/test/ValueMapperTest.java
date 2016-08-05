package cos225.project6.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cos225.project6.math.ValueMapper;

public class ValueMapperTest {
	@Test
	public void test() {
		ValueMapper vm = new ValueMapper(0.5, 1.0);
		
		assertEquals(vm.map(1.0), 1.5, 0.0001);
		assertEquals(vm.map(-1.0), 0.5, 0.0001);
	}

}
