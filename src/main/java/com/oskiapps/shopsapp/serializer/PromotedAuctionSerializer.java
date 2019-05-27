package com.oskiapps.shopsapp.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.oskiapps.shopsapp.model.entities.Auction;

public class PromotedAuctionSerializer extends StdSerializer<Auction> {

	public PromotedAuctionSerializer(Class<Auction> t) {
		super(t);
	}

	@Override
	public void serialize(Auction auction, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeNumberField("id", auction.getId());
		jgen.writeStringField("descriptionShort", auction.getDescriptionShort());
		jgen.writeStringField("name", auction.getName());
		jgen.writeStringField("priceBrutto", auction.getPriceBrutto().toEngineeringString());
		jgen.writeNumberField("idProduct", auction.getProduct().getId());
		jgen.writeNumberField("idImage",
				auction.getProduct().getProductVariants().get(0).getProductImages().get(0).getId());
		jgen.writeEndObject();
	}
}