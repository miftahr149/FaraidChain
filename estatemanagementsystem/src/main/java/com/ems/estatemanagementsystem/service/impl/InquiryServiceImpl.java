package com.ems.estatemanagementsystem.service.impl;

import com.ems.estatemanagementsystem.dto.InquiryDTO;
import com.ems.estatemanagementsystem.entity.ExternalAgency;
import com.ems.estatemanagementsystem.entity.Inquiry;
import com.ems.estatemanagementsystem.repository.ExternalAgencyRepository;
import com.ems.estatemanagementsystem.repository.InquiryRepository;
import com.ems.estatemanagementsystem.service.InquiryService;
import com.ems.estatemanagementsystem.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InquiryServiceImpl implements InquiryService {

  private final InquiryRepository inquiryRepository;
  private final UserService userService;
  private final ExternalAgencyRepository externalAgencyRepository;
  private static final String uploadDirectory = "app/uploads";

  public InquiryServiceImpl(InquiryRepository inquiryRepository, UserService userService,
      ExternalAgencyRepository externalAgencyRepository) {
    this.inquiryRepository = inquiryRepository;
    this.userService = userService;
    this.externalAgencyRepository = externalAgencyRepository;
  }

  @Override
  public Inquiry createInquiry(Inquiry inquiry, List<Long> agencyIds, MultipartFile icFile,
      MultipartFile deathCert) throws IOException {
    inquiry.setUser(userService.getCurrentUser());
    inquiry.setInquiryDate(new Date());

    List<ExternalAgency> agencies = externalAgencyRepository.findAllById(agencyIds);
    inquiry.setInquiryAgency(agencies);

    List<String> inquiryAgencyStatus =
        agencies.stream().map(agency -> "Waiting for Feedback").collect(Collectors.toList());
    inquiry.setInquiryAgencyStatus(inquiryAgencyStatus);

    if (!icFile.isEmpty()) {
      String icFileName = saveFile(icFile);
      inquiry.setIcFilePath(icFileName);
    }

    if (!deathCert.isEmpty()) {
      String deathCertFileName = saveFile(deathCert);
      inquiry.setDeathCertPath(deathCertFileName);
    }

    inquiry.setStatus("Inquiry Sent");

    return inquiryRepository.save(inquiry);
  }

  private String saveFile(MultipartFile file) throws IOException {
    String fileName = file.getOriginalFilename();
    Path filePath = Paths.get(uploadDirectory, fileName);
    Files.write(filePath, file.getBytes());
    return fileName;
  }

  @Override
  public List<InquiryDTO> getInquiryList() {
    List<Inquiry> inquiryList = inquiryRepository.findAll();
    return inquiryList.stream().map((inquiry) -> convertEntityToDto(inquiry))
        .collect(Collectors.toList());
  }

  private InquiryDTO convertEntityToDto(Inquiry inquiry) {
    InquiryDTO inquiryDTO = new InquiryDTO();
    inquiryDTO.setId(inquiry.getId());
    inquiryDTO.setInquiryDate(inquiry.getInquiryDate());
    inquiryDTO.setInquiryFor(inquiry.getInquiryFor());
    inquiryDTO.setInquiryAgency(inquiry.getInquiryAgency());
    inquiryDTO.setInquiryAgencyStatus(inquiry.getInquiryAgencyStatus());
    inquiryDTO.setAgreement(inquiry.getAgreement());
    inquiryDTO.setUser(inquiry.getUser());
    inquiryDTO.setIcFilePath(inquiry.getIcFilePath());
    inquiryDTO.setDeathCertPath(inquiry.getDeathCertPath());
    inquiryDTO.setStatus(inquiry.getStatus());
    // inquiryDTO.setTotalPayment(inquiry.getTotalPayment());
    inquiryDTO
        .setTotalPayment(inquiry.getTotalPayment() != null ? inquiry.getTotalPayment() : 0.0f);
    return inquiryDTO;
  }

  @Override
  public InquiryDTO findInquiryById(Long id) {
    return convertEntityToDto(inquiryRepository.findById(id).orElse(null));
  }

  @Override
  public Inquiry updateInquiry(Inquiry inquiry) {
    Inquiry existingInquiry = getInquiryById(inquiry.getId());

    existingInquiry.setInquiryAgencyStatus(inquiry.getInquiryAgencyStatus());
    existingInquiry.setStatus(inquiry.getStatus());
    existingInquiry.setTotalPayment(inquiry.getTotalPayment());

    return inquiryRepository.save(existingInquiry);
  }

  @Override
  public Inquiry getInquiryById(Long inquiryId) {
    Optional<Inquiry> chosenInquiry = inquiryRepository.findById(inquiryId);

    if (chosenInquiry.isPresent()) {
      Inquiry currentInquiry = chosenInquiry.get();
      return currentInquiry;
    } else {
      return null;
    }
  }

  @Override
  public Inquiry findInquiryNotDTOById(Long id) {
    return inquiryRepository.findById(id).orElse(null);
  }

}
