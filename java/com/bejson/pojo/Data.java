/**
  * Copyright 2022 bejson.com 
  */
package com.bejson.pojo;
import java.util.List;

/**
 * Auto-generated: 2022-05-22 20:8:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private int has_more;
    private Attentions attentions;
    private List<Cards> cards;
    private long next_offset;
    private int _gt_;
    public void setHas_more(int has_more) {
         this.has_more = has_more;
     }
     public int getHas_more() {
         return has_more;
     }

    public void setAttentions(Attentions attentions) {
         this.attentions = attentions;
     }
     public Attentions getAttentions() {
         return attentions;
     }

    public void setCards(List<Cards> cards) {
         this.cards = cards;
     }
     public List<Cards> getCards() {
         return cards;
     }

    public void setNext_offset(long next_offset) {
         this.next_offset = next_offset;
     }
     public long getNext_offset() {
         return next_offset;
     }

    public void set_gt_(int _gt_) {
         this._gt_ = _gt_;
     }
     public int get_gt_() {
         return _gt_;
     }

}