package alla.shtokal.security;

public enum ApplicationUserPermission {
    EVENTS_READ("events:read"),
    EVENTS_WRITE("events:write"),
    STATIONS_READ("stations:read"),
    STATIONS_WRITE("stations:write");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public  String getPermission() {
        return  permission;
    }
}
