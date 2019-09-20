package com.ford.ch.buycheap.controller;

import com.ford.ch.buycheap.model.User;
import com.ford.ch.buycheap.results.ResponseWrapper;
import com.ford.ch.buycheap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userMainService;

	/*@GetMapping(value = "/{id}")
	public ResponseWrapper<Author> getAuthorById(
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id )
	{
		return new ResponseWrapper<>( authorMainService.getById( Integer.parseInt( id ) ), HttpStatus.OK );
	}*/

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getUserById(
            @PathVariable(value = "id") String cdsid) {
        return userMainService.getById(cdsid);
    }

    @GetMapping()
    public ResponseWrapper<Page<User>> getUserAll(Pageable pageable) {
        return new ResponseWrapper<>(userMainService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseWrapper<User> createUser(@Valid @RequestBody User user) {
        return new ResponseWrapper<>(userMainService.add(user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseWrapper<User> deleteUser(
            @Valid @PathVariable(value = "id") String cdsid) {
        return new ResponseWrapper<>(userMainService.deleteById(cdsid), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseWrapper<User> updateUser(@Valid @RequestBody User user,
                                            @Valid @PathVariable(value = "id") String cdsid) {
        return new ResponseWrapper<>(userMainService.update(user, cdsid), HttpStatus.OK);
    }

}
