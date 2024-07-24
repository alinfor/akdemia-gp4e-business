package af.cmr.indyli.akdemia.business.utils;

/**
 * This class contains constant values used as keys for DAOs and services in the
 * Akdemia application. It organizes these keys into nested classes for DAOs and
 * service keys.
 */
public class ConstsValues {

	/**
	 * This inner class contains constant keys for DAOs used in the application.
	 * Each key represents a specific DAO used for database access.
	 */
	public static final class ConstsDAO {
		public static final String COMPANY_DAO_KEY = "companyDAO";
		public static final String EMPLOYEE_DAO_KEY = "employeeDAO";
		public static final String EVALUATION_DAO_KEY = "evaluationDAO";
		public static final String MANAGER_DAO_KEY = "managerDAO";
		public static final String PARTICULAR_DAO_KEY = "particularDAO";
		public static final String PLANNING_DAO_KEY = "planificationDAO";
		public static final String PRIVILEGE_DAO_KEY = "privilegeDAO";
		public static final String REQUIREMENT_DAO_KEY = "requirementDAO";
		public static final String ROLE_DAO_KEY = "roleDAO";
		public static final String SUB_TOPIC_DAO_KEY = "subTopicDAO";
		public static final String TOPIC_DAO_KEY = "topicDAO";
		public static final String TEST_DAO_KEY = "testDAO";
		public static final String TRAINER_DAO_KEY = "trainerDAO";
		public static final String TRAINING_DAO_KEY = "trainingDAO";
		public static final String VALIDATION_TEST_DAO_KEY = "validationTestDAO";
		public static final String USER_DAO_KEY = "userDAO";
		public static final String SESSION_DAO_KEY = "sessionDAO";
		public static final String SERVICE_DAO_KEY = "serviceDAO";
		public static final String PARTICULAR_SUBSCRIPTION_DAO_KEY = "particularSubscriptionDAO";
		public static final String INTRA_SESSION_DAO_KEY ="intraSessionDAO";
		public static final String EMPLOYEE_SUBSCRIPTION_DAO_KEY = "employeeSubscriptionDAO";
		public static final String INTER_SESSION_DAO_KEY ="interSessionDAO";
		
	}

	/**
	 * This inner class contains constant keys for services used in the application.
	 * Each key represents a specific service used for business logic.
	 */
	public static final class ServiceKeys {
		public static final String COMPANY_SERVICE_KEY = "companyService";
		public static final String EMPLOYEE_SERVICE_KEY = "employeeService";
		public static final String EVALUATION_SERVICE_KEY = "evaluationService";
		public static final String MANAGER_SERVICE_KEY = "managerService";
		public static final String PARTICULAR_SERVICE_KEY = "particularService";
		public static final String PRIVILEGE_SERVICE_KEY = "privilegeService";
		public static final String REQUIREMENT_SERVICE_KEY = "requirementService";
		public static final String ROLE_SERVICE_KEY = "roleService";
		public static final String SUB_TOPIC_SERVICE_KEY = "subTopicService";
		public static final String TOPIC_SERVICE_KEY = "topicService";
		public static final String TEST_SERVICE_KEY = "testService";
		public static final String TRAINER_SERVICE_KEY = "trainerService";
        public static final String TRAINING_SERVICE_KEY = "trainingService";
		public static final String VALIDATION_TEST_SERVICE_KEY = "validationTestService";
		public static final String PLANNING_SERVICE_KEY = "planningService";
		public static final String USER_SERVICE_KEY = "userService";
		public static final String USER_SERVICE = "userAuthService";
		public static final String PARTICULAR_SUBSCRIPTION_SERVICE_KEY = "particularSubscriptionService";
		public static final String EMPLOYEE_SUBSCRIPTION_SERVICE_KEY = "employeeSubscriptionService";
		public static final String INTRA_SESSION_SERVICE_KEY = "intraSessionService";
		public static final String INTER_SESSION_SERVICE_KEY = "interSessionService";
		public static final String SESSION_SERVICE_KEY = "sessionService";

	}

}
