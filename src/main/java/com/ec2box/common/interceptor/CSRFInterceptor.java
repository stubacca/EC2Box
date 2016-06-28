/**
 * Copyright 2016 Sean Kavanagh - sean.p.kavanagh6@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ec2box.common.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.interceptor.TokenInterceptor;

public class CSRFInterceptor extends TokenInterceptor {

	private static final long serialVersionUID = 8938421386123543997L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);

		if("GET".equals(request.getMethod())){
			return invocation.invoke();
		}
		else {
			return super.intercept(invocation);
		}
	}
}
