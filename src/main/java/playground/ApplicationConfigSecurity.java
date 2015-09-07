package playground;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//@Configuration
//@EnableWebSecurity
//public class ApplicationConfigSecurity extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService())
//                .passwordEncoder(new Md5PasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/security/logout"))
//                    .and()
//                .formLogin()
//                    .and()
//                .authorizeRequests()
//                    .antMatchers("/", "/info", "/security/logout", "**/*.js", "**/*.css", "**/*.ico").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                .httpBasic()
//                    .and()
//                .csrf()
//                    .disable();
//
//        http.userDetailsService(userDetailsService());
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.userDetailsService(userDetailsService());
//    }
//
//    @Override
//    public UserDetailsService userDetailsService() {
//        return (String username) -> {
//            System.out.println("finding...") ;return new MyUserDetails(username);
//        };
//    }
//
//    public static final class MyUserDetails implements UserDetails {
//
//        private final String username;
//
//        public MyUserDetails(String username) {
//            this.username = username;
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            return Arrays.asList((() -> "USER"));
//        }
//
//        @Override
//        public String getPassword() {
//            return "password";
//        }
//
//        @Override
//        public String getUsername() {
//            return username;
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
//}
