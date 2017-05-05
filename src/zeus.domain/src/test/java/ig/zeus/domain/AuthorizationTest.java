package ig.zeus.domain;

import java.util.LinkedList;
import java.util.List;

import ig.zeus.domain.model.permission.Authorization;
import ig.zeus.domain.model.permission.Permission;
import ig.zeus.domain.model.permission.PermissionPool;
import ig.zeus.domain.model.resource.Resource;
import ig.zeus.domain.model.resource.server.Action;
import ig.zeus.domain.model.resource.server.Controller;
import ig.zeus.domain.model.resource.server.Module;
import ig.zeus.domain.type.PermissionType;
import ig.zeus.domain.type.ResourceType;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AuthorizationTest extends TestCase {
	List<Resource> resources;
	PermissionPool permission;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AuthorizationTest(String testName) {
		super(testName);
		try {
			this.initPermission();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.initReources();
	}

	public void initReources() {
		Module module = new Module();
		module.setSignature("user");
		module.setID(1);

		Controller contro = new Controller();
		contro.setID(2);
		contro.setSignature("manager");

		Action action = new Action();
		action.setID(3);
		action.setSignature("add");

		LinkedList<Resource> linkedList = new LinkedList<Resource>();
		linkedList.add(action);
		contro.setChidren(linkedList);

		linkedList = new LinkedList<Resource>();
		linkedList.add(contro);
		module.setChidren(linkedList);

		resources = new LinkedList<Resource>();
		resources.add(module);
	}

	public void initPermission() throws Exception {
		permission = new PermissionPool(null);
		permission.addPermission(ResourceType.Module, new Permission(1, 1, PermissionType.Access));
		permission.addPermission(ResourceType.Module, new Permission(1, 2, PermissionType.Access));
		permission.addPermission(ResourceType.Controller, new Permission(1, 2, PermissionType.Access));
		permission.addPermission(ResourceType.Action, new Permission(1, 3, PermissionType.Access));
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AuthorizationTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */

	public void testAuthorization() {
		Authorization authorization = new Authorization(resources, permission);
		boolean validate = authorization.validate("user/manager/add", 2);
		System.out.println(validate);
	}
}
