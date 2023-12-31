package in.bushansirgur.expensetrackerapi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prj_name")
	@NotBlank(message = "Project name must not be null")
	@Size(min = 3, message = "Project name must be at least 3 characters")
	private String name;
	
	@Column(name = "prj_description")
	private String description;



	//TODO: Make class for category
	@NotBlank(message = "Category should not be null")
	@Column(name = "prj_category")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tbl_category", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category category;

	@NotNull(message = "Date must not be null")
	private Date date;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
}





















