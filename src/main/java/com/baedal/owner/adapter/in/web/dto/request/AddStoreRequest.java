package com.baedal.owner.adapter.in.web.dto.request;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddStoreRequest {

	private String name;
	private String address;
	private String pictureUrl;
	private LocalDateTime openTime;
	private LocalDateTime closeTime;

}
