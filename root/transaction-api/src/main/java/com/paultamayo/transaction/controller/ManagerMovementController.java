package com.paultamayo.transaction.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.commons.helpers.ApiModel;
import com.paultamayo.commons.utils.ControllerUtil;
import com.paultamayo.transaction.actions.MovementEntry;
import com.paultamayo.transaction.actions.MovementOutput;
import com.paultamayo.transaction.services.ManagerMovementService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("movimientos")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ManagerMovementController {

	private final ManagerMovementService service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "reportes")
	public ResponseEntity<ApiModel<List<MovementOutput>>> generateReport(@RequestParam(name = "clientId") Long clientId,
			@RequestParam(name = "start") LocalDate start, @RequestParam(name = "end") LocalDate end) {
		return ControllerUtil.response(log, () -> service.generateAccountState(clientId, start, end));
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, value = "registrar")
	public ResponseEntity<ApiModel<Long>> register(@RequestBody MovementEntry entry) {
		return ControllerUtil.response(log, () -> service.registerMovement(entry));
	}

}
