db.createCollection('purchasedGlasses',
validator:
{
  $jsonSchema: {
    bsonType: "object",
    required: ["brand", "prescription_left", 'prescription_right', "frame_type", "frame_color", "glass_color_left",
                "glass_color_right", "price", "supplier", "sales_information"],
    properties: {
      brand: { bsonType: "string" },
      prescription_left: { bsonType: "string" },
      prescription_right: { bsonType: "string" },
      frame_type: {
              bsonType: "string",
              enum: ["floating", "paste", "metallic"]
            },
      frame_color: { bsonType: "string" },
      glass_color_right: { bsonType: "string" },
      glass_color_left: { bsonType: "string" },
      price: { bsonType: "double" },
      supplier: { bsonType: "objectId" },
      sales_information: {
              bsonType: "array",
              items: {
                bsonType: "object",
                  required: ["employee", "date", "time"],
                  properties: {
                    employee: { bsonType: "string" },
                    date: { bsonType: "date" },
                    time: { bsonType: "string"}
                  }
              }
            }
    }
  }
}
)