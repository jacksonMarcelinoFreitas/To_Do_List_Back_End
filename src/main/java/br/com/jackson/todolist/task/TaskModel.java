package br.com.jackson.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;

import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private UUID idUser;

  @Column(length = 50)
  private String title;
  private String priority;
  private String description;
  private LocalDateTime endAt;
  private LocalDateTime startAt;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public void setTitle(String title) throws Exception{
    if(title.length() > 50){
      throw new Exception("O campo de title deve conter no máximo 50 caracteres");
    }
    this.title = title;
  }

  public Object status(HttpStatus badRequest) {
    return null;
  }

}
