package com.k15t.pat.registration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.k15t.pat.registration.register.RegistrationControllerTest;
import com.k15t.pat.registration.register.RegistrationRepositoryTest;
import com.k15t.pat.registration.register.RegistrationTest;

@RunWith(Suite.class)
@SuiteClasses({
	RegistrationRepositoryTest.class,
	RegistrationControllerTest.class,
	RegistrationTest.class
})
public class AllTests {

}
