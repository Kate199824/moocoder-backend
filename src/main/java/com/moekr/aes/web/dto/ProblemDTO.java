package com.moekr.aes.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moekr.aes.util.enums.ProblemType;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
public class ProblemDTO {
	@Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "题目名称只能包含大小写字母、数字、下划线和连字符！", groups = PostMapping.class)
	@NotNull(message = "题目名称不能为空！", groups = PostMapping.class)
	private String name;
	@NotNull(message = "题目类型不能为空！", groups = PostMapping.class)
	private ProblemType type;
	@NotNull(message = "题目描述不能为空！", groups = PostMapping.class)
	private String description;
	@JsonProperty("public_files")
	@NotNull(message = "请提供可修改文件列表！", groups = PutMapping.class)
	private Set<String> publicFiles;
	@JsonProperty("protected_files")
	@NotNull(message = "请提供不可修改文件列表！", groups = PutMapping.class)
	private Set<String> protectedFiles;
	@JsonProperty("private_files")
	@NotNull(message = "请提供不可见文件列表！", groups = PutMapping.class)
	private Set<String> privateFiles;
}
