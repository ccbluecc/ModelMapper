package sit.int204.classicmodelsservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.Model.AuthUser;
import sit.int204.classicmodelsservice.Model.Customer;
import sit.int204.classicmodelsservice.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByName(userName);
        if(customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, userName+ " does not exist !!");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return customer.getRole();
            }
        };
        roles.add(grantedAuthority);
        UserDetails userDetails = new AuthUser(userName, customer.getPassword(), roles);
        return userDetails;
    }
}
