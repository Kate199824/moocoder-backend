package com.moekr.moocoder.web.controller.view;

import com.moekr.moocoder.web.controller.AbstractController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractViewController extends AbstractController {
	protected boolean isLogin() {
		try {
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication authentication = context.getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			return userDetails != null;
		} catch (Exception e) {
			return false;
		}
	}
}
