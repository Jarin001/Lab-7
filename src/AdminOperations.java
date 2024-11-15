interface AdminOperations {
    void renameFile(String oldFileName, String newFileName);
    void changePrivileges(String userId, String newPrivilege) throws Exception;
}
