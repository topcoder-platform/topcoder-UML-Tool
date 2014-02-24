package com.topcoder.registration;
/**
*/
public interface RegistrationPersistence{
/**
 * @param contest 
 * @param user 
 * @param role 
 * @param Return 
*/
public void register(Contest contest, User user, ContestRole role) {
}
/**
 * @param contest 
 * @param user 
 * @param role 
 * @param Return 
*/
public void unregister(Contest contest, User user, ContestRole role) {
}
}

