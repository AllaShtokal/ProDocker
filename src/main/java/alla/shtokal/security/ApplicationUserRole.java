package alla.shtokal.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static alla.shtokal.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    GUEST(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STATIONS_READ, STATIONS_WRITE, EVENTS_READ, EVENTS_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(STATIONS_READ, EVENTS_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public  Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name() ));
        return permissions;
    }
}
