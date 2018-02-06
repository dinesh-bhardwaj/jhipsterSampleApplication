/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_REFR_DETAILSDialogComponent } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details-dialog.component';
import { RNS_REFR_DETAILSService } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.service';
import { RNS_REFR_DETAILS } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.model';
import { RNSREFRMASTERService } from '../../../../../../main/webapp/app/entities/rnsrefrmaster';

describe('Component Tests', () => {

    describe('RNS_REFR_DETAILS Management Dialog Component', () => {
        let comp: RNS_REFR_DETAILSDialogComponent;
        let fixture: ComponentFixture<RNS_REFR_DETAILSDialogComponent>;
        let service: RNS_REFR_DETAILSService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_REFR_DETAILSDialogComponent],
                providers: [
                    RNSREFRMASTERService,
                    RNS_REFR_DETAILSService
                ]
            })
            .overrideTemplate(RNS_REFR_DETAILSDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_REFR_DETAILSDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_REFR_DETAILSService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new RNS_REFR_DETAILS(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.rNS_REFR_DETAILS = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'rNS_REFR_DETAILSListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new RNS_REFR_DETAILS();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.rNS_REFR_DETAILS = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'rNS_REFR_DETAILSListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
