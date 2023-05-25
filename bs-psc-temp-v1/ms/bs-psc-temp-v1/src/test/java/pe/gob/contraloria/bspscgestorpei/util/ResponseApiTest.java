package pe.gob.contraloria.bspscgestorpei.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ResponseApiTest {

	@Test
	void EqualsAndHashCodeTest() {
		ResponseApi x = ResponseApi.builder().status("OK").statusCode(200).build();
		ResponseApi y = x;
		ResponseApi z = new ResponseApi();
		z.setStatusCode(x.getStatusCode());
		z.setStatus(x.getStatus());
		z.setData(x.getData()); 
		Assert.assertTrue(x.equals(y) && y.equals(x));
		Assert.assertTrue(x.equals(x) && y.equals(y));
		Assert.assertEquals(x.hashCode(), y.hashCode());
		Assert.assertTrue(x.equals(z) && z.equals(x));
		Assert.assertTrue(x.equals(x) && z.equals(z));
		Assert.assertEquals(z.hashCode(),z.hashCode());
	}
}