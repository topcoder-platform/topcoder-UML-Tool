package com.topcoder.service.studio.submission;
/**
This is main interface of Submission Manager component. It provides operations on contest like add CRUD operations on the submission, prize, and review and submission payment; update submission status and placement; add and remove prizes from submission.
*/
public interface SubmissionManager{
/**
Get submission
@param submissionId 
@param Return 
@return 
*/
public getSubmission(long submissionId) {
}
/**
Get submissions for contest. Note that if celectFullSubmission is true should be returned full link of submission, in other case to return full link payments status should be paid
@param selectFullSubmission 
@param contestId 
@param Return 
@return 
*/
public List<Submission> getSubmissionsForContest(long contestId, boolean selectFullSubmission) {
    return null;
}
/**
Fer submissions by member.
@param userId 
@param Return 
@return 
*/
public List<Submission> getAllSubmissionsByMember(long userId) {
    return null;
}
/**
Update submission,y
@param submission 
@param Return 
*/
public void updateSubmission(submission) {
}
/**
Remove submission, change status to deleted
@param submissionId 
@param Return 
@return 
*/
public boolean removeSubmission(long submissionId) {
    return false;
}
/**
Update submission status.
@param submissionStatusId 
@param submissionId 
@param Return 
*/
public void updateSubmissionStatus(long submissionId, long submissionStatusId) {
}
/**
Update submission rank, add prize for submission depends on rank. Note that unsder contest only 1 submission can have first place, only 1 can have second place. ties is not allowed.
@param submission 
@param Return 
*/
public void updateSubmissionResult(submission) {
}
/**
add prize
@param prize 
@param Return 
*/
public void addPrize(prize) {
}
/**
update prize
@param prize 
@param Return 
*/
public void updatePrize(prize) {
}
/**
remove prize
@param prizeId 
@param Return 
@return 
*/
public boolean removePrize(long prizeId) {
    return false;
}
/**
get prize by id
@param prizeId 
@param Return 
@return 
*/
public getPrize(long prizeId) {
}
/**
add prize to submision
@param submissionid 
@param prizeId 
@param Return 
*/
public void addPrizeToSubmission(long submissionid, long prizeId) {
}
/**
remove prize from submission
@param submissionId 
@param prizeId 
@param Return 
*/
public void removePrizeFromSubmission(long submissionId, long prizeId) {
}
/**
Add submission payment
@param submissionPayment 
@param Return 
*/
public void addSubmissionPayment(submissionPayment) {
}
/**
Update submission payment
@param submissionPayment 
@param Return 
*/
public void updateSubmissionPayment(submissionPayment) {
}
/**
Get submission payment
@param submissionId 
@param Return 
@return 
*/
public getSubmissionPayment(long submissionId) {
}
/**
Add submission review
@param submissionReview 
@param Return 
*/
public void addSubmissionReview(submissionReview) {
}
/**
Update submission review
@param submissionReview 
@param Return 
*/
public void updateSubmissionReview(submissionReview) {
}
/**
Get submission reviews for submission added by id
@param submissionId 
@param Return 
@return 
*/
public List<SubmissionReview> getSubmissionReviews(long submissionId) {
    return null;
}
/**
Get submission review for specific submission and reviewer
@param submissionId 
@param reviewerId 
@param Return 
@return 
*/
public getSubmissionReview(long submissionId, long reviewerId) {
}
/**
Remove submission reviews for submission
@param submissionId 
@param Return 
@return 
*/
public boolean removeSubmissionReviews(long submissionId) {
    return false;
}
/**
Remove specific submission review
@param submissionId 
@param reviewerId 
@param Return 
@return 
*/
public boolean removeSubmissionReview(long submissionId, long reviewerId) {
    return false;
}
}

