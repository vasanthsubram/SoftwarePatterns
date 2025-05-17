package patterns.behavioural.template_method;

 abstract class Authenticator {

    // Template method
    public final void authenticate(String username, String password) {
        if (!checkCredentials(username, password)) {
            System.out.println("Authentication failed.");
            return;
        }
        fetchUserRoles(username);
        logAuthentication(username);
    }

    // Steps that may vary
    protected abstract boolean checkCredentials(String username, String password);
    protected abstract void fetchUserRoles(String username);

    // Common step
    protected void logAuthentication(String username) {
        System.out.println("User " + username + " authenticated and logged.");
    }
}

 class DatabaseAuthenticator extends Authenticator {
    @Override
    protected boolean checkCredentials(String username, String password) {
        // Simulate DB check
        System.out.println("Checking credentials in database...");
        return "user".equals(username) && "pass".equals(password);
    }

    @Override
    protected void fetchUserRoles(String username) {
        System.out.println("Fetching roles from database for user " + username);
    }
}

 class LdapAuthenticator extends Authenticator {
    @Override
    protected boolean checkCredentials(String username, String password) {
        System.out.println("Checking credentials in LDAP...");
        return "ldapUser".equals(username) && "ldapPass".equals(password);
    }

    @Override
    protected void fetchUserRoles(String username) {
        System.out.println("Fetching roles from LDAP for user " + username);
    }
}




public class TemplateMethodDemo {
    public static void main(String[] args) {
        Authenticator dbAuth = new DatabaseAuthenticator();
        dbAuth.authenticate("user", "pass");

        System.out.println();

        Authenticator ldapAuth = new LdapAuthenticator();
        ldapAuth.authenticate("ldapUser", "ldapPass");
    }
}
