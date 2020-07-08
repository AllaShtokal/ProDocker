package alla.shtokal.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class ApplicationUser implements UserDetails {

    private  final Set<? extends GrantedAuthority> grantedAuthorities;
    private  final String password;
    private  final String username;
    private final boolean isAccountNonLocked;
    private final boolean isAccountNonExpired;
    private final boolean isCredentionalsNonExpired;
    private final boolean isEnabled;

    public ApplicationUser(String username,
                           String password,
                           Set<? extends GrantedAuthority> grantedAuthorities,
                           boolean isAccountNonLocked,
                           boolean isAccountNonExpired,
                           boolean isCredentionalsNonExpired,
                           boolean isEnabled) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isCredentionalsNonExpired = isCredentionalsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentionalsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
