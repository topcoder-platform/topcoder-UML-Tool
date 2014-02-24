package com.topcoder.registration;
/**
*/
public abstract class AbstractConfigurationContestDetailsDataSource implements ContestDetailsDataSource{
/**
 * @param configuration 
*/
protected AbstractConfigurationContestDetailsDataSource(ConfigurationObject configuration) {
}
/**
 * @param contest 
 * @param Return 
 * @return 
*/
public Map<ContestRole, List<<String>> getRegistrationValidatorNames(Contest contest) {
    return null;
}
}

