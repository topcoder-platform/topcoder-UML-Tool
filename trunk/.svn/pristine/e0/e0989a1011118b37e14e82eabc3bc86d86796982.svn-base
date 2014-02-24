package com.topcoder.service.studio.contest.bean;
import javax.ejb.*;
import com.topcoder.util.log.*;
import javax.persistence.*;
import com.topcoder.service.studio.contest.*;
/**
 * <p>
 * This bean class implements the ContestManagerLocal and ContestManagerRemote interfaces. It is a stateless session bean with @Stateless annotation. It would simply use the JPA to manage the entities in the persistence.  NOTE: the transaction is managed by the container. 
 * 
 * It uses the Logging Wrapper to perform the logging. 
 * 
 * It should have annotations: 
 * @Stateless
 * @TransactionManagement(TransactionManagementType.CONTAINER)
 * @DeclareRoles("Administrator")
 * 
 * And all public methods in this bean should have the following annotations: 
 * @PermitAll   -- indicating only "Administrator" role is allowed to perform the operation. 
 * @TransactionAttribute(TransactionAttributeType.REQUIRED)   -- indicating the transaction is required. 
 * 
 * Thread-safety: The variables in this class are initialized once in the initialize method after the bean is instantiated by EJB container. 
 * They would be never be changed afterwards. So they won't affect the thread-safety of this class when its EJB methods are called. 
 * So this class can be used thread-safely in EJB container. </p>
*/
public class ContestManagerBean implements ContestManagerRemote, ContestManagerLocal{
/**
 * <p>Represents the SessionContext injected by the EJB container automatically. It is marked with @Resource annotation. 
 * It's non-null after injected when this bean is instantiated. And its reference is not changed afterwards. 
 * It is used in the initialize method to lookup JNDI resources. </p>
*/
private SessionContext sessionContext;
/**
 * Represent the default document path id, it is used to retrieve the FilePath object to set to the added document if its path is not set. 
 * It is initialized in the initialize method, and never changed afterwards.  It  can be any long value. It must be non-null after set.
*/
private Long defaultDocumentPathId;
/**
 * <p>Represents the persistence unit name to lookup the EntityManager from the SessionContext. 
 * It is initialized in the initialize method, and never changed afterwards.  It must be non-null, non-empty string. </p>
*/
private String unitName;
/**
 * <p>Represents the logger to log invocation information and exception. 
 * It is initialized in the initialize method, and never changed afterwards.  It can be null, and if so, logging is disabled. </p>
*/
private Log logger;
/**
 * <p>Represents the DocumentContentManager object to manage the document content. 
 * It is initialized in the initialize method, and never changed afterwards.  It must be non-null after set. </p>
*/
private DocumentContentManager documentContentManager;
/**
 * <p>Represents the id of  contest status indicating the contest is active. 
 * It is initialized in the initialize method, and never changed afterwards.  It  can be any long value. It must be non-null after set. </p>
*/
private Long activeContestStatusId;
/**
 * Empty constructor.
*/
public ContestManagerBean() {
}
/**
 * <p>This method is called after this bean is constructed by the EJB container.  This method should be marked with @PostConstruct annotation.
 * 
 * This method will load the unitName from the sessionContext via the lookup method. 
 * 
 * NOTE: This method is a callback method, and only Runtime exception can be thrown from it. 
 * Impl Note: 
 * // get persistence unit name , must be non-null, non-empty string. 
 * unitName = (String) sessionContext.lookup("unitName");
 * 
 * // get activeContestStatusId, must be non-null Long value.
 * activeContestStatusId = (Long) sessionContext.lookup("activeContestStatusId");
 * 
 * // get defaultDocumentPathId, must be non-null Long value.
 * defaultDocumentPathId = (Long) sessionContext.lookup("defaultDocumentPathId");
 * 
 * // load "loggerName", can be null, but must be non-empty. 
 * loggerName = (String) sessionContext.lookup("loggerName");
 * if loggerName != null
 *       logger = LogManager.getLog(loggerName);
 * end if
 * 
 * // load attributes to create DocumentContentManager object. 
 * // load full qualified class name of DocumentContentManager
 * className = (String) sessionContext.lookup("documentContentManagerClassName");
 * // load attribute keys, which is a String delimited by comma
 * String[] attrKeys = ((String) sessionContext.lookup("documentContentManagerAttributeKeys")).split(",") ;
 * 
 * create a Map to hold attributes: attrs = new Map<String, Object>();
 * foreach attributeKey in attrKeys
 *      // load corresponding value, and save into attrs Map. 
 *      attrs.put(attributeKey, sessionContext.lookup(attributeKey));
 * end for
 * 
 * finally use Reflection API to call the ctor of the DocumentContentManager class (identified by the loaded className) with the attrs Map as the argument to create an DocumentContentManager object.  ( The ctor to call should have signature:  ctor(Map<String, Object> attrs)). 
 * 
 * assign loaded / created values to instance variables. </p>
 * #exception
 * throws ContestConfigurationException if any required parameter is missing, or any configured value is invalid, 
 *                   it is also used to wrap the underlying exceptions.
 * @param Return 
*/
private void initialize() {
}
/**
 * Create new contest, and return the created contest. 
 * 
 * #Param
 * contest - the contest to create. 
 * 
 * #Return - the created contest. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null. 
 * throw EntityAlreadyExistsException if the entity already exists in the persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.persist(contest) to add the contest into persistence.
 * and then return contest.
 * @param contest 
 * @param Return 
 * @return 
*/
public Contest createContest(Contest contest) {
    return null;
}
/**
 * Get contest by id, and return the retrieved contest.  If the contest doesn't exist, null is returned. 
 * 
 * #Param
 * contestId - the contest id. 
 * 
 * #Return - the retrieved contest, or null if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest. 
 * return contest.
 * @param contestId 
 * @param Return 
 * @return 
*/
public Contest getContest(long contestId) {
    return null;
}
/**
 * Get projects's contests by the project id. A list of contests associated with the given tcDirectProjectId should be returned.  If there is no such contests, an empty list should be returned. 
 * 
 * #Param
 * tcDirectProjectId - the project id. 
 * 
 * #Return - a list of associated contests. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contests.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * create query = em.createQuery("select c from Contest c where c.tcDirectProjectId = :tcDirectProjectId");
 * set parameter : query.setParameter("tcDirectProjectId", tcDirectProjectId);
 * execute query to get results = query.getResultList();
 * shallowly copy the elements in results list into a List<Contest> to return.
 * @param tcDirectProjectId 
 * @param Return 
 * @return 
*/
public List<Contest> getContestsForProject(long tcDirectProjectId) {
    return null;
}
/**
 * Update contest data. Note that all data can be updated only if contest is not active. If contest is active it is possible to increase prize amount and duration.
 * 
 * #Param
 * contest - the contest to update. 
 * 
 * #exception
 * throw IllegalArgumentException if the argument is null.
 * throw EntityNotFoundException if the contest doesn't exist in persistence. 
 * throw ContestManagementException if any error occurs when updating contest.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call result = em.find(Contest.class, new Long(contestId)) to get the contest from persistence
 * if result's status is active (statusId is the same as activeContestStatusId)
 *       ensure all atributes (except the endDate) in contest are the same as those in result
 *       (if the attribute is a data entity, only data entity's id needs to be compared.). 
 *      throw ContestManagementException if not. 
 *      call em.merge(contest) to update the endDate into persistence. 
 * else 
 *      call em.merge(contest) to update the contest into persistence.
 * end if
 * @param contest 
 * @param Return 
*/
public void updateContest(Contest contest) {
}
/**
 * Update contest status to the given value. 
 * 
 * #Param
 * contestId - the contest id. 
 * newStatusId - the new status id. 
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding Contest or ContestStatus in persistence. 
 * throw ContestStatusTransitionException if it's not allowed to update the contest to the given status. 
 * throw ContestManagementException if any error occurs when updating contest's status.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest. 
 * call contestStatus = em.find(ContestStatus.class, new Long(contestStatusId)) to get the contestStatus. 
 * Ensure we can change contest's status from its current one to the new one (according to Visio-ClientCockpit_Competition_State_Chart_Diagram.pdf), throw ContestManagementException if we cannot. 
 * otherwise set contestStatus to contest, and then call em.merge(contest) to update the contest's status.
 * @param newStatusId 
 * @param contestId 
 * @param Return 
*/
public void updateContestStatus(long contestId, long newStatusId) {
}
/**
 * Get client for contest, the client id is returned. 
 * 
 * #Param
 * contestId - the contest id. 
 * 
 * #Return - the client id. 
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding contest (or project) in persistence. 
 * throw ContestManagementException if any error occurs when retrieving the client id.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * call project = em.find(Project.class, contest.getTcDirectProjectId()) to get the project.
 * return project.getUserId().longValue().    // return 0 if project.getUserId() is null.
 * @param contestId 
 * @param Return 
 * @return 
*/
public long getClientForContest(long contestId) {
    return 0;
}
/**
 * Get client for project, and return the retrieved client id. 
 * 
 * #Param
 * projectId - the project id. 
 * 
 * #Return - the client id. 
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding project in persistence. 
 * throw ContestManagementException if any error occurs when retrieving the client id.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call project = em.find(Project.class, new Long(projectId)) to get the project.
 * return project.getUserId().longValue().    // return 0 if project.getUserId() is null.
 * @param projectId 
 * @param Return 
 * @return 
*/
public long getClientForProject(long projectId) {
    return 0;
}
/**
 * Add contest status, and return the added contest status. 
 * 
 * #Param
 * contestStatus - the contest status to add. 
 * 
 * #return - the added contest status. 
 * 
 * #exceptionthrow IllegalArgumentException if the arg is null. 
 * throw EntityAlreadyExistsException if the entity already exists in the persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.persist(contestStatus) to add the contestStatus into persistence.
 * and then return contestStatus.
 * @param contestStatus 
 * @param Return 
 * @return 
*/
public ContestStatus addContestStatus(ContestStatus contestStatus) {
    return null;
}
/**
 * Update contest status.
 * 
 * #Param
 * contestStatus - the contest status to update. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null.
 * throw EntityNotFoundException if the contestStatus doesn't exist in persistence.
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.merge(contestStatus) to update the contestStatus into persistence.
 * @param contestStatus 
 * @param Return 
*/
public void updateContestStatus(ContestStatus contestStatus) {
}
/**
 * Remove contest status, return true if the contest status exists and removed successfully, return false if it doesn't exist. 
 * 
 * #Param
 * contestStatusId - the contest status id. 
 * 
 * #Return -  true if the contest status exists and removed successfully, return false if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contestStatus = em.find(ContestStatus.class, new Long(contestStatusId)) to get the contestStatus. 
 * if contestStatus is null
 *     return false
 * else 
 *     call em.remove(contestStatus) to remove the contestStatus
 *     return true
 * end if
 * @param contestStatusId 
 * @param Return 
 * @return 
*/
public boolean removeContestStatus(long contestStatusId) {
    return false;
}
/**
 * Get contest status, and return the retrieved contest status. Return null if it doesn't exist. 
 * 
 * #Param
 * contestStatusId - the contest status id. 
 * 
 * #Return - the retrieved contest status, or null if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest status.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contestStatus = em.find(ContestStatus.class, new Long(contestStatusId)) to get the contestStatus. 
 * return contestStatus.
 * @param contestStatusId 
 * @param Return 
 * @return 
*/
public ContestStatus getContestStatus(long contestStatusId) {
    return null;
}
/**
 * Add new document, and return the added document. 
 * 
 * #Param
 * document - the document to add. 
 * 
 * #Return - the added document. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null. 
 * throw EntityAlreadyExistsException if the document already exists in the persistence. 
 * throw ContestManagementException if any other error occurs. 
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * if document.getPath() == null    
 *       call docPath = em.find(FilePath.class, defaultDocumentPathId) to get the default file path. 
 *       throw ContestManagementException if docPath is null. 
 *       otherwise set docPath to document's path
 * end if
 * if document.getSystemFileName() == null
 *       call UUID.randomUUID().toString() to generate a unique fileName
 *       set the fileName to document's systemFileName
 * end if
 * call em.persist(document) to add the document into persistence.
 * and then return document.
 * @param document 
 * @param Return 
 * @return 
*/
public Document addDocument(Document document) {
    return null;
}
/**
 * Update document.
 * 
 * #Param
 * document - the document to update. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null.
 * throw EntityNotFoundException if the document doesn't exist in persistence.
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.merge(document) to update the document into persistence.
 * @param document 
 * @param Return 
*/
public void updateDocument(Document document) {
}
/**
 * Get document by id, and return the retrieved document. Return null if the document doesn't exist. 
 * 
 * #Param
 * documentId - the document id. 
 * 
 * #Return - the retrieved document, or null if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting document.#impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call document = em.find(Document.class, new Long(documentId)) to get the document. 
 * return document.
 * @param documentId 
 * @param Return 
 * @return 
*/
public Document getDocument(long documentId) {
    return null;
}
/**
 * Remove document, return true if the document exists and removed successfully, return false if it doesn't exist. 
 * 
 * #Param
 * documentId - the document id. 
 * 
 * #Return -  true if the document exists and removed successfully, return false if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call document = em.find(Document.class, new Long(documentId)) to get the document. 
 * if document is null
 *     return false
 * else 
 *     call em.remove(document) to remove the document
 *     return true
 * end if
 * @param documentId 
 * @param Return 
 * @return 
*/
public boolean removeDocument(long documentId) {
    return false;
}
/**
 * Add document to contest. Nothing happens if the document already exists in contest.  
 * 
 * #Param
 * documentId - the document id. 
 * contestId - the contest id. 
 * #exception
 * throw EntityNotFoundException if there is no corresponding document or contest in persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call document = em.find(Document.class, new Long(documentId)) to get the document. 
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * add document to contest.documents property, and add contest to document.contests property. 
 * finally call em.merge(contest) to update the relationship.
 * @param documentId 
 * @param contestId 
 * @param Return 
*/
public void addDocumentToContest(long documentId, long contestId) {
}
/**
 * Remove document from contest. Return true if the document exists in the contest and removed successfully, return false if it doesn't exist in contest. 
 * 
 * #Param
 * documentId - the document id. 
 * contestId - the contest id. 
 * 
 * #Return - true if the document exists in the contest and removed successfully, return false if it doesn't exist in contest. 
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding document or contest in persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call document = em.find(Document.class, new Long(documentId)) to get the document. 
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * if document exists in contest.documents property
 *       remove document from contest.documents property, and remove contest from document.contests property. 
 *       call em.merge(contest) to update the relationship
 *       return true
 * else 
 *       return false
 * end if
 * @param documentId 
 * @param contestId 
 * @param Return 
 * @return 
*/
public boolean removeDocumentFromContest(long documentId, long contestId) {
    return false;
}
/**
 * Add contest category, and return the added contest category.
 * 
 * #Param
 * contestCategory - the contest category to add. 
 * 
 * #return - the added contest category. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null. 
 * throw EntityAlreadyExistsException if the entity already exists in the persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.persist(contestCategory) to add the contestCategory into persistence.
 * and then return contestCategory.
 * @param contestCategory 
 * @param Return 
 * @return 
*/
public ContestCategory addContestCategory(ContestCategory contestCategory) {
    return null;
}
/**
 * Update contest category
 * 
 * #Param
 * contestCategory - the contest category to update. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null.
 * throw EntityNotFoundException if the contestCategory doesn't exist in persistence.
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.merge(contestCategory) to update the contestCategory into persistence.
 * @param contestCategory 
 * @param Return 
*/
public void updateContestCategory(ContestCategory contestCategory) {
}
/**
 * Remove contest category, return true if the contest category exists and removed successfully, return false if it doesn't exist. 
 * 
 * #Param
 * contestCategoryId - the contest category id. 
 * 
 * #Return - true if the contest category exists and removed successfully, return false if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if fail to remove the contest category when it exists.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contestCategory = em.find(ContestCategory.class, new Long(contestCategoryId)) to get the contestCategory. 
 * if contestCategory is null
 *     return false
 * else 
 *     call em.remove(contestCategory) to remove the contestCategory
 *     return true
 * end if
 * @param contestCategoryId 
 * @param Return 
 * @return 
*/
public boolean removeContestCategory(long contestCategoryId) {
    return false;
}
/**
 * Get contest category, and return the retrieved contest category. Return null if it doesn't exist. 
 * 
 * #ParamcontestCategoryId - the contest category id. 
 * 
 * #Return - the retrieved contest category, or null if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest category.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contestCategory = em.find(ContestCategory.class, new Long(contestCategoryId)) to get the contestCategory. 
 * return contestCategory.
 * @param contestCategoryId 
 * @param Return 
 * @return 
*/
public ContestCategory getContestCategory(long contestCategoryId) {
    return null;
}
/**
 * Add contest configuration parameter, and return the added contest configuration parameter. 
 * 
 * #Param
 * contestConfig - the contest configuration parameter to add. 
 * 
 * #return - the added contest configuration parameter. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null. 
 * throw EntityAlreadyExistsException if the entity already exists in the persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.persist(contestConfig) to add the contestConfig into persistence.
 * and then return contestConfig.
 * @param contestConfig 
 * @param Return 
 * @return 
*/
public ContestConfig addConfig(ContestConfig contestConfig) {
    return null;
}
/**
 * Update contest configuration parameter
 * 
 * #Param
 * contestConfig - the contest configuration parameter to update. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null.
 * throw EntityNotFoundException if the contest configuration parameter doesn't exist in persistence.
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.merge(contestConfig) to update the contestConfig into persistence.
 * @param contestConfig 
 * @param Return 
*/
public void updateConfig(ContestConfig contestConfig) {
}
/**
 * Get contest configuration parameter by id, and return the retrieved contest configuration parameter. Return null if it doesn't exist. 
 * 
 * #Param
 * contestConfigId - the contest configuration parameter id. 
 * 
 * #Return - the retrieved contest configuration parameter, or null if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest configuration parameter
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contestConfig = em.find(ContestConfig.class, new Long(contestConfigId)) to get the contestConfig. 
 * return contestConfig.
 * @param contestConfigId 
 * @param Return 
 * @return 
*/
public ContestConfig getConfig(long contestConfigId) {
    return null;
}
/**
 * Save document content in file system. This methods should use DocumentContentManager interface.
 * 
 * #param
 * documentId - the document
 * documentContent - the file data of the document to save. 
 * 
 * #exception
 * throw IllegalArgumentException if fileData argument is null or empty array. 
 * throw EntityNotFoundException if the document doesn't exist in persistence. 
 * throw ContestManagementException if any other error occurs.
 * throw - let exceptions from DocumentContentManager propagate.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * get document = em.find(Document.class, new Long(documentId));
 * compose the file path:  path = document.getPath().getPath() + File.separator + document.getSystemFileName();  
 * ( if the document.getPath().getPath() doesn't end with a separator, File.separator should be appended, otherwise it's unnecessary. )
 * then call documentContentManager.saveDocumentContent(path, documentContent)
 * @param documentContent 
 * @param documentId 
 * @param Return 
*/
public void saveDocumentContent(long documentId, byte[] documentContent) {
}
/**
 * Get document content to return.  If the document is not saved, null is returned.  It will use DocumentContentManager to get document content. 
 * It can also return empty array if the document content is empty.
 * 
 * #Param
 * documentId - the document id. 
 * 
 * #Return - the document content in byte array. If the document is not saved, null is returned. 
 * 
 * #exception
 * throw EntityNotFoundException if the document doesn't exist in persistence. 
 * throw ContestManagementException if any other error occurs.
 * throw - let exceptions from DocumentContentManager propagate.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * get document = em.find(Document.class, new Long(documentId));
 * compose the file path:  path = document.getPath().getPath() + File.separator + document.getSystemFileName();  
 * ( if the document.getPath().getPath() doesn't end with a separator, File.separator should be appended, otherwise it's unnecessary. )
 * then return documentContentManager.getDocumentContent(path)
 * @param documentId 
 * @param Return 
 * @return 
*/
public byte[] getDocumentContent(long documentId) {
    return 0;
}
/**
 * Add configuration parameter into the contest.  Nothing happens if the configuration parameter already exists in the contest. 
 * 
 * #Param
 * contestId - the contest id. 
 * configId - the configuration parameter id.
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding Contest or Config in persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * call config = em.find(Config.class, new Long(configId)) to get the config. 
 * add config to contest.config property,
 * finally call em.merge(contest) to update the relationship.
 * @param configId 
 * @param contestId 
 * @param Return 
*/
public void addContestConfigurationParameter(long contestId, long configId) {
}
/**
 * Add configuration parameter to contest type. Nothing happens if the configuration parameter already exists in contest type. 
 * 
 * #Param
 * contestTypeId - the contest type id. 
 * configId - the configuration parameter id.
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding ContestType or Config in persistence.
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call contestType = em.find(ContestType.class, new Long(contestTypeId)) to get the contestType.
 * call config = em.find(Config.class, new Long(configId)) to get the config. 
 * if config already exists in contestType.config (compare their ids)
 *     do nothings
 * else
 *     add config to contestType.config property,
 *     finally call em.merge(contestType) to update the relationship.
 * end if.
 * @param contestTypeId 
 * @param configId 
 * @param Return 
*/
public void addContestTypeConfigurationParameter(long contestTypeId, long configId) {
}
/**
 * Check the document's content exists or not.  Return true if it exists, return false otherwise.  It will use DocumentContentManager to check document content's existence. 
 * 
 * #Param
 * document - the document. 
 * 
 * #Return - true if the document content exists, return false otherwise.
 * 
 * #exception
 * throw EntityNotFoundException if the document doesn't exist in persistence. 
 * throw ContestManagementException if any other error occurs.
 * throw - let exceptions from DocumentContentManager propagate.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * get document = em.find(Document.class, new Long(documentId));
 * compose the file path:  path = document.getPath().getPath() + File.separator + document.getSystemFileName();  
 * ( if the document.getPath().getPath() doesn't end with a separator, File.separator should be appended, otherwise it's unnecessary. )
 * then return documentContentManager.existDocumentContent(path)
 * @param documentId 
 * @param Return 
 * @return 
*/
public boolean existDocumentContent(long documentId) {
    return false;
}
/**
 * Get all contest statuses to return.  If no contest status exists, return an empty list. 
 * 
 * #Return - a list of contest statuses. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest statuses.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * create query = em.createQuery("select s from ContestStatus") to select all ContestStatus objects.
 * execute query to get results = query.getResultList();
 * shallowly copy elements in results into List<ContestStatus> to return.
 * @param Return 
 * @return 
*/
public List<ContestStatus> getAllContestStatuses() {
    return null;
}
/**
 * Get all contest categories to return.  If no contest category exists, return an empty list. 
 * 
 * #Return - a list of contest categories. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest categories.
 * 
 * #implcall em = getEntityManager() to obtain the EntityManager. 
 * create query = em.createQuery("select s from ContestCategory") to select all ContestCategory objects.
 * execute query to get results = query.getResultList();
 * shallowly  copy elements in results into List<ContestCategory> to return.
 * @param Return 
 * @return 
*/
public List<ContestCategory> getAllContestCategories() {
    return null;
}
/**
 * Get all studio file types to return.  If no studio file type exists, return an empty list. 
 * 
 * #Return - a list of studio file types
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting studio file types.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * create query = em.createQuery("select s from StudioFileType") to select all StudioFileType objects.
 * execute query to get results = query.getResultList();
 * shallowly copy elements in results into List<StudioFileType> to return.
 * @param Return 
 * @return 
*/
public List<StudioFileType> getAllStudioFileTypes() {
    return null;
}
/**
 * Add contest type configuration parameter, and return the added contest type configuration parameter. 
 * 
 * #Param
 * contestTypeConfig - the contest type configuration parameter to add. 
 * 
 * #return - the added contest type configuration parameter. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null. 
 * throw EntityAlreadyExistsException if the entity already exists in the persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.persist(contestTypeConfig) to add the contestTypeConfig into persistence.
 * and then return contestTypeConfig.
 * @param contestTypeConfig 
 * @param Return 
 * @return 
*/
public ContestTypeConfig addContestTypeConfig(ContestTypeConfig contestTypeConfig) {
    return null;
}
/**
 * Update contest type configuration parameter
 * 
 * #Param
 * contestTypeConfig - the contest type configuration parameter to update. 
 * 
 * #exception
 * throw IllegalArgumentException if the arg is null.
 * throw EntityNotFoundException if the contest type configuration parameter doesn't exist in persistence.
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call em.merge(contestTypeConfig) to update the contestTypeConfig into persistence.
 * @param contestTypeConfig 
 * @param Return 
*/
public void updateContestTypeConfig(ContestTypeConfig contestTypeConfig) {
}
/**
 * Get contest type configuration parameter by id, and return the retrieved contest type configuration parameter. Return null if it doesn't exist. 
 * 
 * #Param
 * contestTypeConfigId - the contest type configuration parameter id. 
 * 
 * #Return - the retrieved contest type configuration parameter, or null if it doesn't exist. 
 * 
 * #exception
 * throw ContestManagementException if any error occurs when getting contest type configuration parameter
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager. 
 * call contestTypeConfig = em.find(ContestTypeConfig.class, new Long(contestTypeConfigId)) to get the contestTypeConfig. 
 * return contestTypeConfig.
 * @param contestTypeConfigId 
 * @param Return 
 * @return 
*/
public ContestTypeConfig getContestTypeConfig(long contestTypeConfigId) {
    return null;
}
/**
 * Add prize to the given contest. Nothing happens if the prize already exists in contest.  
 * 
 * #Param
 * contestId - the contest id. 
 * prizeId - the prize id. 
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding prize or contest in persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call prize = em.find(Prize.class, new Long(prizeId)) to get the prize. 
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * add contest to prize.contests property. 
 * finally call em.merge(prize) to update the relationship.
 * @param prizeId 
 * @param contestId 
 * @param Return 
*/
public void addPrizeToContest(long contestId, long prizeId) {
}
/**
 * Remove prize from contest. Return true if the prize exists in the contest and removed successfully, return false if it doesn't exist in contest. 
 * 
 * #Param
 * prizeId - the prize id. 
 * contestId - the contest id. 
 * 
 * #Return - true if the prize exists in the contest and removed successfully, return false if it doesn't exist in contest. 
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding prize or contest in persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call prize = em.find(Prize.class, new Long(prizeId)) to get the prize. 
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * if contest exists in prize.contests property
 *       remove contest from prize.contests property
 *       call em.merge(prize) to update the relationship
 *       return true
 * else 
 *       return false
 * end if
 * @param prizeId 
 * @param contestId 
 * @param Return 
 * @return 
*/
public boolean removePrizeFromContest(long contestId, long prizeId) {
    return false;
}
/**
 * Retrieve all prizes in the given contest to return.  An empty list is returned if there is no such prizes. 
 * 
 * #Param
 * contestId - the contest id. 
 * 
 * #Return - a list of prizes.
 * 
 * #exception
 * throw EntityNotFoundException if there is no corresponding contest in persistence. 
 * throw ContestManagementException if any other error occurs.
 * 
 * #impl
 * call em = getEntityManager() to obtain the EntityManager.
 * call contest = em.find(Contest.class, new Long(contestId)) to get the contest.
 * call query = em.createQuery("select p from Prize p where :contest member of p.contests") to get prizes in the contest. 
 * query.setParameter("contest", contest);
 * then call query.getResultList() to retrieve selected prizes, and shallowly copy them into a List<Prize> to return.
 * @param contestId 
 * @param Return 
 * @return 
*/
public List<Prize> getContestPrizes(long contestId) {
    return null;
}
/**
 * Return the EntityManager looked up from the session context. 
 * Simply return  (EntityManager) sessionContext.lookup(unitName);
 * 
 * #Return - the EntityManager looked up from the session context. 
 * 
 * #exception
 * throw SubmissionManagementException if fail to get the EntityManager from the sessionContext.
 * @param Return 
 * @return 
*/
private EntityManager getEntityManager() {
    return null;
}
}

