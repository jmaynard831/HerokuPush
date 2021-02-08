package com.jwtTestTwo.jwtTestTwo.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
//	STUDENT(Sets.newHashSet()), 
//	ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)), 
//	SUBADMIN(Sets.newHashSet(COURSE_READ, STUDENT_READ));
USER, ADMIN;
	
	//private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRole() {
		//this.permissions = permissions;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		Set<SimpleGrantedAuthority> permissions = new HashSet<>();
//				getPermissions().stream()
//				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;
	}

//	public Set<ApplicationUserPermission> getPermissions() {
//		return permissions;
//	}
}
