package chnu.edu.inno.controller;


/*
  @author   george
  @project   inno
  @class  ItemController
  @version  1.0.0 
  @since 27/09/2026 - 19.09
*/

import chnu.edu.inno.model.Item;
import chnu.edu.inno.model.dto.response.ApiResponse;
import chnu.edu.inno.model.dto.response.BaseMetaData;
import chnu.edu.inno.model.dto.response.PaginationMetaData;
import chnu.edu.inno.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @GetMapping()
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItemById(id);
    }

    //----------------  More ---------------------------

    @GetMapping("/response/{id}")
    public ApiResponse<BaseMetaData, Item> getItemByIdAsApiResponse(@PathVariable String id) {
        return itemService.getItemByIdAsApiResponse(id);
    }

    @GetMapping("/page")
    public ApiResponse<PaginationMetaData, Item> getItemsPage(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "5", required = false) Integer size

    ) {
        return itemService.getPage(page, size);
    }





}
