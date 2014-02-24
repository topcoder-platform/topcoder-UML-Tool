package com.topcoder.registration.datasources;
/**
*/
public class JSONContestDetailsDataSource implements ContestDetailsDataSource{
/**
*/
private Map<ContestRole, List<String>> validatorNames = <<constructor>>;
/**
*/
private Map<ContestType, List<ContestRole>> roles = <<constructor>>;
/**
 * @param url 
*/
public JSONContestDetailsDataSource(URL url) {
}
/**
 * @param Return 
 * @return 
*/
public List<Contest> getAllContests() {
    return null;
}
/**
 * @param Return 
 * @return 
*/
public List<Contest> getOpenContests() {
    return null;
}
/**
 * @param type 
 * @param Return 
 * @return 
*/
public List<Contest> getOpenContestsByType(ContestType type) {
    return null;
}
/**
 * @param contest 
 * @param Return 
 * @return 
*/
public List<String> getRegistrationValidatorNames(Contest contest) {
    return null;
}
/**
 * @param filter 
 * @param Return 
 * @return 
*/
public List<Contest> searchContests(Filter filter) {
    return null;
}
/**
 * @param role 
 * @param name 
 * @param Return 
*/
public void addValidatorName(ContestRole role, String name) {
}
/**
 * @param role 
 * @param name 
 * @param Return 
*/
public void removeValidatorName(ContestRole role, String name) {
}
/**
 * @param role 
 * @param Return 
*/
public void clearValidatorNames(ContestRole role) {
}
/**
 * @param Return 
*/
public void clearAllValidatorNames() {
}
/**
 * @param type 
 * @param role 
 * @param Return 
*/
public void addContestTypeRole(ContestType type, ContestRole role) {
}
/**
 * @param type 
 * @param role 
 * @param Return 
*/
public void removeContestTypeRole(ContestType type, ContestRole role) {
}
/**
 * @param type 
 * @param Return 
*/
public void clearContestTypeRoles(ContestType type) {
}
/**
 * @param Return 
*/
public void clearAllContestTypeRoles() {
}
/**
 * @param role 
 * @param Return 
 * @return 
*/
public List<String> getValidatorNames(ContestRole role) {
    return null;
}
/**
 * @param type 
 * @param Return 
 * @return 
*/
public List<ContestRole> getContestTypeRoles(ContestType type) {
    return null;
}
}

