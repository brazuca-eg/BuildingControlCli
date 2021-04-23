package ua.nure.kravchenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.nure.kravchenko.entity.Balance;
import ua.nure.kravchenko.entity.Location;
import ua.nure.kravchenko.entity.app.Statistic;
import ua.nure.kravchenko.entity.help.AuthRequest;
import ua.nure.kravchenko.entity.User;
import ua.nure.kravchenko.entity.help.LocationFindAdressReq;
import ua.nure.kravchenko.entity.help.LocationRequest;
import ua.nure.kravchenko.entity.help.RegistrationRequest;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public User auth(AuthRequest authRequest) {
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8080/auth/login", authRequest, User.class);
        return responseEntity.getBody();
    }

    public User register(RegistrationRequest registrationRequest) {
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8080/auth/register", registrationRequest, User.class);
        User user = responseEntity.getBody();
        return user;
    }

    public List<User> users(HttpEntity req) {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("http://localhost:8080/manager/users", HttpMethod.GET, req, new ParameterizedTypeReference<List<User>>() {
        });
        return responseEntity.getBody();
    }

    public User user(int id, HttpEntity req) {
        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/manager/users/" + id, HttpMethod.GET, req, new ParameterizedTypeReference<User>() {
        });
        return responseEntity.getBody();
    }

    public Balance acceptRequest(int id, HttpEntity req) {
        ResponseEntity<Balance> result = restTemplate.postForEntity("http://localhost:8080/manager/users/" + id + "/accept", req, Balance.class);
        return result.getBody();
    }

    public Balance declineRequest(int id, HttpEntity req) {
        ResponseEntity<Balance> result = restTemplate.postForEntity("http://localhost:8080/manager/users/" + id + "/decline", req, Balance.class);
        return result.getBody();
    }

    public Location createLocation(HttpHeaders headers, LocationRequest locationRequest){
        HttpEntity<LocationRequest> request = new HttpEntity<>(locationRequest, headers);
        ResponseEntity<Location> result = restTemplate.postForEntity( "http://localhost:8080/manager/locations/creation", request,Location.class);
        return result.getBody();
    }

    public List<Location> getAllLocations(HttpHeaders headers){
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<List<Location>> responseEntity = restTemplate.exchange("http://localhost:8080/manager/locations", HttpMethod.GET, request, new ParameterizedTypeReference<List<Location>>() {
        });
        return responseEntity.getBody();
    }

    public Location getLocation(HttpHeaders headers, int id){
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Location> responseEntity = restTemplate.exchange("http://localhost:8080/manager/locations/" + id, HttpMethod.GET, request, new ParameterizedTypeReference<Location>() {
        });
        return responseEntity.getBody();
    }

    public List<User> freeUsers(HttpHeaders headers){
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("http://localhost:8080/manager/users/free", HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>() {
        });
        return responseEntity.getBody();
    }

    public User setLocationToUser(HttpHeaders headers, int userId, LocationFindAdressReq address){
        HttpEntity<LocationFindAdressReq> request = new HttpEntity<>(address, headers);
        ResponseEntity<User> result = restTemplate.postForEntity( "http://localhost:8080/manager/users/" + userId +"/location", request, User.class);
        return result.getBody();
    }

    public Statistic getDailyStatistics(HttpHeaders headers, int locationId){
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Statistic> responseEntity = restTemplate.exchange("http://localhost:8080/manager/statistics/" + locationId, HttpMethod.GET, request, new ParameterizedTypeReference<Statistic>() {
        });
        return responseEntity.getBody();
    }


}
