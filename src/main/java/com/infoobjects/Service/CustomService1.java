// package com.infoobjects.Service;

// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.infoobjects.Entity.User;
// import com.infoobjects.Repo.UserRepo;
// import com.infoobjects.UserDto.SignupDto;

// public class CustomService1 {
//     @Autowired
//     private UserRepo userRepo;
//     @Autowired
//     private ModelMapper modelMapper;
//     public SignupDto createUser(SignupDto signupDto){

//         User user=this.dtoToUser(signupDto);
//         User user1=userRepo.save(user);
//         return this.usertoDto(user1); 
//     }
    
// }
